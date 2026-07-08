from fastapi import APIRouter

router = APIRouter()


@router.get("/health")
async def health_check():
    print("Health check endpoint called")
    return {"status": "ok"}
