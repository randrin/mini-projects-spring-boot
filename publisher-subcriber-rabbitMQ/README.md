## Set up RabbitMQ in your operating system

- Download and install ERlang http://erlang.org/download/otp_win64_22.3.exe
- Downlaod and install RabbitMQ https://github.com/rabbitmq/rabbitmq-server/releases/download/v3.8.8/rabbitmq-server-3.8.8.exe
- Go to RabbitMQ Server install Directory C:\Program Files\RabbitMQ Server\rabbitmq_server-3.8.3\sbin
- Run command rabbitmq-plugins enable rabbitmq_management
- Open browser and enter http://localhost:15672/ to redirect to RabbitMQ Dashboard
- Also we can Open it with IP Address http://127.0.0.1:15672
- Login page default username and password is guest
- After successfully login you should see RabbitMQ Home page


## Set up RabbitMQ in your operating system with docker

- Run the command line
```bash
  docker run -d --hostname my-rabbit --name some-rabbit -p 15672:15672 -p 5672:5672 rabbitmq:3-management
```
