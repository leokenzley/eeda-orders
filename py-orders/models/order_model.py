from itertools import product

from pydantic import BaseModel
from models.product_model import ProductModel

class OrderModel(BaseModel):
    orderId: str
    createdDate: str
    totalValue: float
    products: ProductModel
    paymentType: str