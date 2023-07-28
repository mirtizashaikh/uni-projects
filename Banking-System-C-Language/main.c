#include <stdio.h>

// Function to deposit money
void deposit(float *balance, float amount) {
    *balance += amount;
}

// Function to withdraw money
void withdraw(float *balance, float amount) {
    if (*balance >= amount) {
        *balance -= amount;
    } else {
        printf("Insufficient balance!\n");
    }
}

int main() {
    float balance = 0.0;
    int choice;
    float amount;

    printf("Simple Banking System\n");

    while (1) {
        printf("\nCurrent Balance: %.2f\n", balance);
        printf("1. Deposit\n");
        printf("2. Withdraw\n");
        printf("3. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                printf("Enter the amount to deposit: ");
                scanf("%f", &amount);
                deposit(&balance, amount);
                printf("Deposited %.2f successfully!\n", amount);
                break;

            case 2:
                printf("Enter the amount to withdraw: ");
                scanf("%f", &amount);
                withdraw(&balance, amount);
                break;

            case 3:
                printf("Exiting the program. Thank you!\n");
                return 0;

            default:
                printf("Invalid choice. Please try again.\n");
        }
    }

    return 0;
}
