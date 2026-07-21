import os

RABBITMQ_HOST = os.getenv("RABBITMQ_HOST", "localhost")
RABBITMQ_PORT = int(os.getenv("RABBITMQ_PORT", "5672"))
RABBITMQ_USERNAME = os.getenv("RABBITMQ_USERNAME", "guest")
RABBITMQ_PASSWORD = os.getenv("RABBITMQ_PASSWORD", "guest")
RABBITMQ_QUEUE = os.getenv("RABBITMQ_QUEUE", "email-generation-queue")

OPENAI_API_KEY = os.getenv("OPENAI_API_KEY", "")
SEND_EMAIL_URL = os.getenv(
    "SEND_EMAIL_URL", "http://localhost:8080/api/v1/dispatch-email/send"
)
