from django.shortcuts import render
from rest_framework.viewsets import ModelViewSet

from .models import Passenger
from .serializers import PassengerSerializer

class PassengerViewSet(ModelViewSet):
    queryset = Passenger.objects.all()
    serializer_class = PassengerSerializer