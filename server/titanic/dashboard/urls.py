from rest_framework.routers import DefaultRouter

from .views import PassengerViewSet, PassengerUploadCSVViewset

router = DefaultRouter()

router.register('passengers', PassengerViewSet, basename='passenger-view')
router.register('upload', PassengerUploadCSVViewset, basename='passenger-upload-view')

urlpatterns = router.urls