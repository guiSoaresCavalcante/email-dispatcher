import json

import pika

from app.core.config import RABBITMQ_QUEUE
from app.messaging.connection import get_connection


def process_message(
    ch: pika.channel.Channel,
    method: pika.spec.Basic.Deliver,
    properties: pika.spec.BasicProperties,
    body: bytes,
) -> None:
    try:
        message = json.loads(body)
        print("Mensagem recebida: %s", message)

        # TODO: Agent de email

        ch.basic_ack(delivery_tag=method.delivery_tag)
    except Exception:
        print("Erro ao processar mensagem")
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
