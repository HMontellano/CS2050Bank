# CS2050Bank

## ACCOUNT ADT

**Attributes:**
- `account_number`: Unique identifier for the account
- `account_holder`: Name of the account holder
- `balance`: Current balance in the account

**Methods:**
- `deposit(amount)`: Adds the specified amount to the balance
- `withdraw(amount)`: Subtracts the specified amount from the balance if sufficient funds are available
- `get_balance()`: Returns the current balance
- `get_account_number()`: Returns the account number
- `get_account_holder()`: Returns the account holder's name
- `set_account_holder(name)`: Sets the account holder's name

## SavingsAccount Subclass

**Attributes:**
- `interest_rate`: Interest rate for the savings account

**Methods:**
- `add_interest()`: Adds interest to the balance based on the interest rate

## CheckingAccount Subclass

**Attributes:**
- `overdraft_limit`: Overdraft limit for the checking account

**Methods:**
- `withdraw(amount)`: Overrides the base class method to allow overdrafts up to the overdraft limit
