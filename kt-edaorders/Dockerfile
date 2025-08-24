# Use uma imagem oficial do Java 21
FROM eclipse-temurin:21-jdk-alpine

# Diretório de trabalho dentro do container
WORKDIR /app

# Copia o JAR buildado para dentro do container
COPY build/libs/*.jar app.jar

# Expondo a porta da aplicação
EXPOSE 8082

# Comando para iniciar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
