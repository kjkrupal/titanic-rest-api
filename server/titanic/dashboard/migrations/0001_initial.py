# Generated by Django 3.0.8 on 2020-07-04 21:39

from django.db import migrations, models
import uuid


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='Passenger',
            fields=[
                ('id', models.UUIDField(default=uuid.uuid4, editable=False, primary_key=True, serialize=False)),
                ('passenger_id', models.IntegerField()),
                ('survived', models.BooleanField(default=False)),
                ('ticket_class', models.IntegerField()),
                ('name', models.CharField(max_length=255)),
                ('sex', models.CharField(choices=[('M', 'Male'), ('F', 'Female'), ('U', 'Unknown')], default='U', max_length=10)),
                ('age', models.IntegerField()),
                ('sibsp', models.IntegerField()),
                ('parch', models.IntegerField()),
                ('ticket', models.CharField(max_length=1024)),
                ('fare', models.FloatField()),
                ('cabin', models.CharField(max_length=255)),
                ('embarked', models.CharField(max_length=2)),
            ],
        ),
    ]
