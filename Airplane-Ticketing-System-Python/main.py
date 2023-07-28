class Airplane:

  def __init__(self, capacity):
    self.capacity = capacity
    self.available_seats = capacity
    self.passengers = []

  def book_seat(self, passenger):
    if self.available_seats > 0:
      self.passengers.append(passenger)
      self.available_seats -= 1
      print(f"Seat booked for {passenger}.")
      return True
    else:
      print("Sorry, the airplane is full. Seat booking failed.")
      return False

  def get_available_seats(self):
    return self.available_seats


class Passenger:

  def __init__(self, name, passport_number):
    self.name = name
    self.passport_number = passport_number

  def __str__(self):
    return f"{self.name} (Passport: {self.passport_number})"


def main():
  airplane_capacity = 50
  airplane = Airplane(airplane_capacity)

  while True:
    print("\nMenu:")
    print("1. Book a ticket")
    print("2. View available seats")
    print("3. Exit")

    choice = int(input("Enter your choice: "))

    if choice == 1:
      name = input("Enter passenger name: ")
      passport_number = input("Enter passport number: ")

      passenger = Passenger(name, passport_number)
      if airplane.book_seat(passenger):
        print("Ticket booked successfully!")
      else:
        print("Ticket booking failed.")
    elif choice == 2:
      print(f"Available seats: {airplane.get_available_seats()}")
    elif choice == 3:
      print("Thank you for using the airplane ticketing system.")
      break
    else:
      print("Invalid choice. Please try again.")


if __name__ == "__main__":
  main()
