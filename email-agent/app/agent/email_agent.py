import httpx
from langchain_openai import ChatOpenAI
from langchain_core.prompts import ChatPromptTemplate

from app.core.config import SEND_EMAIL_URL, OPENAI_API_KEY


class EmailAgent:
    def __init__(self) -> None:
        self.llm = ChatOpenAI(
            model="gpt-4o-mini",
            api_key=OPENAI_API_KEY,
        )
        self.prompt = ChatPromptTemplate.from_messages(
            [
                (
                    "system",
                    "Você é um especialista em marketing digital. "
                    "Sua tarefa é gerar e-mails de marketing profissionais, "
                    "persuasivos e personalizados com base nas informações fornecidas. "
                    "Responda APENAS em formato JSON com as chaves 'subject' e 'body'. "
                    "O body deve ser em formato HTML.",
                ),
                (
                    "human",
                    "Gere um e-mail marketing com base nas seguintes informações:\n\n"
                    "Título da campanha: {title}\n"
                    "Nome do contato: {contactName}\n"
                    "Observação: {note}\n"
                    "Informações adicionais: {additionalInfo}\n\n"
                    "Responda em JSON com 'subject' e 'body'.",
                ),
            ]
        )
        self.chain = self.prompt | self.llm

    def generate_email(self, message: dict) -> None:
        import json

        response = self.chain.invoke(
            {
                "title": message.get("title", ""),
                "contactName": message.get("contactName", ""),
                "note": message.get("note", ""),
                "additionalInfo": message.get("additionalInfo", ""),
            }
        )

        print("Resposta do LLM:", response.content)
        content = response.content
        # Parse JSON from LLM response
        if "```json" in content:
            content = content.split("```json")[1].split("```")[0]
        elif "```" in content:
            content = content.split("```")[1].split("```")[0]

        email_data = json.loads(content.strip())

        payload = {
            "toEmail": message.get("email", ""),
            "subject": email_data["subject"],
            "body": email_data["body"],
        }

        self._send_email(payload)

    def _send_email(self, payload: dict) -> None:
        response = httpx.post(
            SEND_EMAIL_URL,
            json=payload,
            headers={"Content-Type": "application/json"},
        )
        response.raise_for_status()
        print(f"E-mail enviado com sucesso para {payload['toEmail']}")
