docker build -t credentium-service .

docker run -d -p 8080:8080 --name container-docker credentium-service

docker build -t credentium-service .