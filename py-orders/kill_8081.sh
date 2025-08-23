#!/bin/bash

# Verifica se existe algum processo rodando na porta 8081
PID=$(lsof -t -i:8081)

if [ -z "$PID" ]; then
  echo "Nenhum processo encontrado na porta 8081 🚀"
else
  echo "Matando processo(s) na porta 8081 (PID: $PID) ❌"
  kill -9 $PID
  echo "Processo(s) encerrado(s) com sucesso ✅"
fi
