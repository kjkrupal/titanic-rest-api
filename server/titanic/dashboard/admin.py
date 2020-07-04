from django.contrib import admin

from .models import Passenger

@admin.register(Passenger)
class PassengerAdmin(admin.ModelAdmin):
    fields = ('id', 'passenger_id', 'survived', 'ticket_class', 'name', 'age', 'sex', 'sibsp', 'parch', 'ticket', 'fare', 'cabin', 'embarked',)
    list_display = ('passenger_id', 'name', 'age', 'sex', 'survived',)
    readonly_fields = ('id',)