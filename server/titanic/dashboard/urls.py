from rest_framework.routers import DefaultRouter

from .views import PassengerViewSet

router = DefaultRouter()

router.register('passengers', PassengerViewSet)

urlpatterns = router.urls