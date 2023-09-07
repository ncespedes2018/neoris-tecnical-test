@echo off
call mvn install -f account-manager-parent\pom.xml
call mvn install -f user-manager-parent\pom.xml

docker-compose up -d

:: Pausa para mantener la ventana abierta (opcional)
pause