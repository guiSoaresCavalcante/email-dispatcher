# Email Dispatcher Web

Interface web para o sistema Email Dispatcher, desenvolvida com Angular 17.

## Funcionalidades

- **Lista de Deals**: Exibe todos os deals do CRM com barra de pesquisa para filtrar por título ou nome do contato.
- **Detalhe do Deal**: Exibe as informações de um deal específico com formulário editável para disparar emails.
- **Disparo de Email**: Envia os dados do formulário para a API que processa e gera o email via agente de IA.

## Tecnologias

- Angular 17 (Standalone Components)
- TypeScript
- Nginx (servidor de produção)
- Docker

## Estrutura do Projeto

```
src/
├── app/
│   ├── components/
│   │   ├── deal-list/        # Tela principal com lista de deals
│   │   └── deal-detail/      # Tela de detalhe com formulário
│   ├── services/
│   │   ├── deal.model.ts     # Interfaces/modelos
│   │   └── deal.service.ts   # Serviço HTTP
│   ├── app.component.ts      # Componente raiz
│   ├── app.config.ts         # Configuração da aplicação
│   └── app.routes.ts         # Rotas
├── index.html
├── main.ts
└── styles.css
```

## Desenvolvimento Local

### Pré-requisitos

- Node.js 20+
- npm

### Instalação

```bash
npm install
```

### Executar em modo desenvolvimento

```bash
npm start
```

A aplicação estará disponível em `http://localhost:4200`.

O proxy de desenvolvimento redireciona chamadas `/api` para `http://localhost:8080` (API backend).

## Docker

### Build da imagem

```bash
docker build -t email-dispatcher-web .
```

### Executar com Docker Compose

Na raiz do projeto:

```bash
docker compose up email-dispatcher-web
```

A interface estará disponível na porta configurada pela variável `WEB_PORT` (padrão: 4200).

## Endpoints Consumidos

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/api/v1/crm/deals` | Lista todos os deals |
| GET | `/api/v1/crm/deals/{id}` | Busca deal por ID |
| POST | `/api/v1/dispatch-email/` | Dispara geração de email |
