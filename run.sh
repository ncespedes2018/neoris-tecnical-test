#!/bin/bash

# Ruta al primer proyecto Maven
proyecto1="account-manager-parent"
# Ruta al segundo proyecto Maven
proyecto2="user-manager-parent"

# Compilar el primer proyecto Maven
cd "$proyecto1"
mvn clean install

# Compilar el segundo proyecto Maven
cd "$proyecto2"
mvn clean install

# Volver al directorio original (si es necesario)
cd -

# Ejecutar docker-compose
docker-compose up -d
