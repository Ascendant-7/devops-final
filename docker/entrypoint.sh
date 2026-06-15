#!/bin/bash
set -e

echo "=== Starting Web Server Container Services ==="

# 1. Start SSH Service (Alpine uses /usr/sbin/sshd directly)
echo "Starting OpenSSH Server (Port 22)..."
/usr/sbin/sshd

# 2. Start Nginx Service
echo "Starting Nginx Reverse Proxy (Port 80 -> 8080)..."
nginx

# 3. Clone or Update Spring Boot Project
echo "Checking Spring Boot Project..."
if [ -d "/app/project/.git" ]; then
    echo "Project folder already exists. Pulling latest changes..."
    cd /app/project
    git pull
else
    echo "Cloning Spring Boot Project..."
    GIT_REPO_URL="https://github.com/Ascendant-7/devops-final.git"
    git clone $GIT_REPO_URL /app/project
fi

# 4. Build and Run Spring Boot
echo "Building and Running Spring Boot application..."
cd /app/project

# Ensure the Maven wrapper script has execution permissions
chmod +x mvnw

# Run the application (This stays in the foreground to keep the container running)
./mvnw spring-boot:run
