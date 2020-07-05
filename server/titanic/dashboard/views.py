import csv
import io
import json

from rest_framework import status
from rest_framework.viewsets import ModelViewSet, ViewSet
from rest_framework.mixins import CreateModelMixin
from rest_framework.parsers import FileUploadParser
from rest_framework.response import Response

from .models import Passenger
from .serializers import PassengerSerializer, PassengerFileUploadSerializer, PassengerCSVRowSerializer

class PassengerViewSet(ModelViewSet):
    queryset = Passenger.objects.all()
    serializer_class = PassengerSerializer

class PassengerUploadCSVViewset(CreateModelMixin, ViewSet):
    file_serializer_class = PassengerFileUploadSerializer
    passenger_serializer_class = PassengerSerializer
    passenger_csv_row_serializer_class = PassengerCSVRowSerializer

    def create(self, request, *args, **kwargs):
        serializer = self.file_serializer_class(data=request.data)
        serializer.is_valid(raise_exception=True)
        file = serializer.validated_data['file']
        decoded_file = file.read().decode().splitlines()
        reader = csv.DictReader(decoded_file)
        for row in reader:
            row_serializer = self.passenger_csv_row_serializer_class(data=row)
            if row_serializer.is_valid():
                row_serializer.create(row_serializer.data)
        return Response(status=status.HTTP_204_NO_CONTENT)