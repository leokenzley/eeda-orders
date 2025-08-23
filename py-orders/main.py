from fastapi import FastAPI
from pydantic import BaseModel
import pika
import json
from models.order_model import OrderModel

app = FastAPI()

# Modelo da requisição
class Product(BaseModel):
    id: str
    quantity: int


def publish_message(order: OrderModel):
    # Conexão com RabbitMQ
    credentials = pika.PlainCredentials("admin", "admin")
    connection = pika.BlockingConnection(
        # Sefor rodar localmente -> pika.ConnectionParameters(host="localhost", credentials=credentials)
        # Rodando em um container
        pika.ConnectionParameters(host="eda-rabbitmq", credentials=credentials)
    )
    channel = connection.channel()

    # Declara a fila
    channel.queue_declare(queue="create-order", durable=False)

    # Publica a mensagem
    channel.basic_publish(
        exchange="exg.direct.order",
        routing_key="rk.order",
        body=json.dumps(order),
        properties=pika.BasicProperties(
            delivery_mode=2,  # persiste a mensagem
        ),
    )

    connection.close()


@app.post("/api/v1/orders")
def create_order(order: OrderModel):
    publish_message(order.dict())
    return {"status": "Order sent to queue", "orderId": order.orderId}
