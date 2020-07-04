import uuid

from django.db import models

# Create your models here.
class Passenger(models.Model):
    
    MALE = 'M'
    FEMALE = 'F'
    UNKNOWN = 'U'
    SEXES = [
        (MALE, 'Male'),
        (FEMALE, 'Female'),
        (UNKNOWN, 'Unknown'),
    ]
    
    id = models.UUIDField(
        primary_key=True, default=uuid.uuid4, editable=False
    )

    passenger_id = models.IntegerField()
    survived = models.BooleanField(default=False)
    ticket_class = models.IntegerField()
    name = models.CharField(max_length=255)
    sex = models.CharField(choices=SEXES, default=UNKNOWN, max_length=10)
    age = models.IntegerField()
    sibsp = models.IntegerField()
    parch = models.IntegerField()
    ticket = models.CharField(max_length=1024)
    fare = models.FloatField()
    cabin = models.CharField(max_length=255)
    embarked = models.CharField(max_length=2)

    def __str__(self):
        return f'{self.passenger_id} - {self.name}'



