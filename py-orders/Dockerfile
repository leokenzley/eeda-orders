# Usar uma imagem base do Python
FROM python:3.11-slim

# Criar diretório da app
WORKDIR /app

# Copiar dependências
COPY requirements.txt .

# Instalar dependências
RUN pip install --no-cache-dir -r requirements.txt

# Copiar o código
COPY . .

# Expor a porta (mesma do Uvicorn)
EXPOSE 8081

# Comando padrão para rodar a API
CMD ["uvicorn", "main:app", "--host", "0.0.0.0", "--port", "8081"]
