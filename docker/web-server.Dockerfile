FROM eclipse-temurin:25-jdk-alpine

RUN apk update && \
    apk add --no-cache nginx openssh git bash curl php php-cli php-mbstring php-xml php-phar php-openssl php-json php-mysqli nodejs npm sqlite python3 mysql-client mariadb-connector-c && \
    rm -rf /var/cache/apk/*

RUN curl -sS https://getcomposer.org/installer | php -- --install-dir=/usr/local/bin --filename=composer

RUN mkdir -p /var/run/sshd && \
    echo 'root:Hello@123' | chpasswd && \
    ssh-keygen -A && \
    sed -i 's/#PermitRootLogin prohibit-password/PermitRootLogin yes/' /etc/ssh/sshd_config

COPY nginx-spring.conf /etc/nginx/http.d/default.conf

WORKDIR /app
RUN mkdir -p /app/project

COPY entrypoint.sh /entrypoint.sh
RUN chmod +x /entrypoint.sh

EXPOSE 80 8080 22

ENTRYPOINT ["/entrypoint.sh"]
