docker compose down

docker stop f90ce909d9ca
docker rm f90ce909d9ca

docker compose up -d --build
