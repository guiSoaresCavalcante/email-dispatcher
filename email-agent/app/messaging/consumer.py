import json

import pika

from app.agent.email_agent import EmailAgent
from app.core.config import RABBITMQ_QUEUE
from app.messaging.connection import get_connection

email_agent = EmailAgent()


def process_message(
    ch: pika.channel.Channel,
    method: pika.spec.Basic.Deliver,
    properties: pika.spec.BasicProperties,
    body: bytes,
) -> None:
    try:
        print("Recebendo a mensagem")
        message = json.loads(body)
        print("Mensagem recebida: %s", message)

        email_agent.generate_email(message)

        ch.basic_ack(delivery_tag=method.delivery_tag)
    except Exception as e:
        print("Erro ao processar mensagem: %s" % e)
        ch.basic_nack(delivery_tag=method.delivery_tag, requeue=False)


def start_consumer() -> None:
    connection = get_connection()
    channel = connection.channel()

    channel.queue_declare(queue=RABBITMQ_QUEUE, durable=True)
    channel.basic_qos(prefetch_count=1)
    channel.basic_consume(
        queue=RABBITMQ_QUEUE,
        on_message_callback=process_message,
    )

    print("Aguardando mensagens na fila '%s'..." % RABBITMQ_QUEUE)
    channel.start_consuming()
