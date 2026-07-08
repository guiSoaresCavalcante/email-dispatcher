from fastapi import FastAPI
from contextlib import asynccontextmanager
import threading

from app.api.routes import router as api_router
from app.messaging.consumer import start_consumer


@asynccontextmanager
async def lifespan(app: FastAPI):
    consumer_thread = threading.Thread(target=start_consumer, daemon=True)
    consumer_thread.start()
    yield


app = FastAPI(title="Email Dispatcher API", version="1.0.0", lifespan=lifespan)
app.include_router(api_router, prefix="/api")
