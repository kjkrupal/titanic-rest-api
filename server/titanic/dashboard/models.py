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

    passenger_id = models.IntegerField(null=True)
    survived = models.BooleanField(default=False, null=True)
    ticket_class = models.IntegerField(null=True)
    name = models.CharField(max_length=255, null=True)
    sex = models.CharField(choices=SEXES, default=UNKNOWN, max_length=10, null=True)
    age = models.IntegerField(null=True)
    sibsp = models.IntegerField(null=True)
    parch = models.IntegerField(null=True)
    ticket = models.CharField(max_length=1024, null=True)
    fare = models.FloatField(null=True)
    cabin = models.CharField(max_length=255, null=True)
    embarked = models.CharField(max_length=2, null=True)

    def __str__(self):
        return f'{self.passenger_id} - {self.name}'



