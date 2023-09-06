@echo off

:: Ruta al primer proyecto Maven
set proyecto1=account-manager-parent

:: Ruta al segundo proyecto Maven
set proyecto2=user-manager-parent

:: Compilar el primer proyecto Maven
cd /d %proyecto1%
mvn clean install

:: Compilar el segundo proyecto Maven
cd /d %proyecto2%
mvn clean install

:: Volver al directorio original (si es necesario)
cd /d %~dp0

docker-compose up -d

:: Pausa para mantener la ventana abierta (opcional)
pause