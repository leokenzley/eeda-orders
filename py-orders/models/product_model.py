from pydantic import BaseModel

# Modelo da requisição
class ProductModel(BaseModel):
    id: str
    quantity: int