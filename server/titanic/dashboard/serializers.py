from rest_framework import serializers
from rest_framework.serializers import ModelSerializer, Serializer

from .models import Passenger

import logging
logger = logging.getLogger(__name__)

class PassengerSerializer(ModelSerializer):
    class Meta:
        model = Passenger
        fields = '__all__'

class PassengerFileUploadSerializer(Serializer):
    file = serializers.FileField()

    class Meta:
        fields = ('file',)

class PassengerCSVRowSerializer(Serializer):
    PassengerId = serializers.IntegerField()
    Survived = serializers.IntegerField()
    Pclass = serializers.IntegerField()
    Name = serializers.CharField(max_length=1024)
    Sex = serializers.CharField(max_length=10)
    Age = serializers.FloatField()
    SibSp = serializers.IntegerField()
    Parch = serializers.IntegerField()
    Ticket = serializers.CharField(max_length=1024)
    Fare = serializers.FloatField()
    Cabin = serializers.CharField(max_length=1024)
    Embarked = serializers.CharField(max_length=2)

    def create(self, validated_data):
        
        logger.error(validated_data)
        passenger = Passenger()
        passenger.passenger_id = validated_data.get('PassengerId')
        passenger.survived = validated_data.get('Survived')
        passenger.ticket_class = validated_data.get('Pclass')
        passenger.name = validated_data.get('Name')
        passenger.sex = validated_data.get('Sex')
        passenger.sibsp = validated_data.get('SibSp')
        passenger.parch = validated_data.get('Parch')
        passenger.ticket = validated_data.get('Ticket')
        passenger.fare = validated_data.get('Fare')
        passenger.cabin = validated_data.get('Cabin')
        passenger.embarked = validated_data.get('Embarked')
        passenger.save()
        return passenger
        #return Passenger.objects.create(**data)
