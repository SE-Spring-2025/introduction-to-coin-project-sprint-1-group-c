# Coins Project
## Version 0.1
* Folder and tool infrastructure
* Basic Coin class with tests and demo

### Members:
- Patrick A
- Melody D
- Amanda C
- Logan H  

### 3/26/25
- Created Sprint 1 branch (A.C)
- Added the code Required for Sprint 1 to the new branch
- Pushed to git (A.C)
- Pulled from get (P.A)
- Updated README file.
- Pushed to git (A.C)


### 3/31/25
# Coins Project
## Sprint 2
### Sprint Goal
The goal of the sprint is to address a change request. Our client wishes to have separate and distinguishable coin objects for the various coin types (e.g., quarter, dime). And, as always, our code meets our corporate requirements: checkstyle, unit testing.
### Sprint tasks
1. Refactor Coin as an abstract class
2. Create two-level coin hierarchy with Coin at top and Dollar, HalfDollar, Quarter, Dime, Nickel, Penny classes extending Coin. These classes should pass checkstyle and pass tests.
3. Update CoinTest to support changes in Coin class.
4. Write JUnit test classes for the concrete coin classes (e.g., Dime, Penny).
5. Write a Demo class that demonstrates our code (Coin class) satisfies customer requirements.
### Domain details
Client wants separate and distinguishable coin objects instead of a singular object that has varying field values. In essence, the software should reflect, or model, the physical reality. The physical reality is that quarters are different kinds of objects from pennies even though they have some commonalities.

Client still wants to be able to create multiple coin objects of various value denominations. Most attributes are "built in" to the coin denomination; for example, images and mottos for coins are fixed. Consequently, constructor doesn't need many parameters and there should not be any way to change these attributes once they are set. (Coins don't change after construction!) **NEW DESIGN:** The Quarter constructor knows all the attribute values and needs a superclass constructor that accepts all these.

United States coins specifications are indicated in table below.
Familiar name | value | frontMotto | backMotto | frontLabel | backLabel | frontImage | backImage | valueDescription | ridged edge | metallurgy
--------------| ----- | ---------- | --------- | ---------- | --------- | ---------- | --------- | ---------------- | ----------- | ----------
Penny | 0.01 | "IN GOD WE TRUST" | "E PLURIBUS UNUM" | "LIBERTY" | "UNITED STATES OF AMERICA" | "A_Lincoln" | "Lincoln_Memorial" | "ONE CENT" | no | "Copper"
Nickel | 0.05 | "IN GOD WE TRUST" | "E PLURIBUS UNUM" | "LIBERTY" | "UNITED STATES OF AMERICA" | "T_Jefferson" | "Jefferson_Memorial" | "FIVE CENTS" | no | "Cupro-Nickel"
Dime | 0.10 | "IN GOD WE TRUST" | "E PLURIBUS UNUM" | "LIBERTY" | "UNITED STATES OF AMERICA" | "F_Roosevelt" | "Torch_Branches" | "ONE DIME" | yes | "Cupro-Nickel"
Quarter | 0.25 | "IN GOD WE TRUST" | "E PLURIBUS UNUM" | "LIBERTY" | "UNITED STATES OF AMERICA" | "G_Washington" | "Eagle" | "QUARTER DOLLAR" | yes | "Cupro-Nickel"
HalfDollar | 0.50 | "IN GOD WE TRUST" | "E PLURIBUS UNUM" | "LIBERTY" | "UNITED STATES OF AMERICA" | "J_Kennedy" | "Presidential_Seal" | "HALF DOLLAR" | yes | "Cupro-Nickel"
Dollar | 1.00 | "IN GOD WE TRUST" | "E PLURIBUS UNUM" | "LIBERTY" | "UNITED STATES OF AMERICA" | "S_Anthony" | "Moon_Eagle" | "ONE DOLLAR" | yes | "Cupro-Nickel"

### Implementation details
Our test classes and demo classes do not have to meet checkstyle or testing requirements. Only "production code" classes must meet those requirements.

We will separate the "main" code from the "test" code from the "demo" code with subfolders inside the src/ folder. For example, we will have    ```src/main/``` and ```src/demo/``` and ```src/test/``` folders.


# Coins Project
# 4/2/25
## Sprint 3
### Sprint Goal
The goal of the sprint is to refactor the metallurgy to use the Strategy design pattern. And, as always, our code meets our corporate requirements: checkstyle, unit testing.
### Sprint tasks
1. Create Metallurgy hierarchy (interface and concrete classes).
2. Test the concrete Metallurgy implementations of the interface. (The interface does not need a test because it has no executable code.)
3. Refactor the Coin class to have a Metallurgy delegate and add the smelt() method that uses the delegate. Refactor the Coin constructor to set the delegate with the concrete Metallurgy object passed by the coin subclass and then call its own smelt method to set the metallurgy String field.
4. Refactor the concrete coin classes (e.g., Penny) to no longer pass a metallurgy string but to instead pass a Metallurgy object.
5. Write a Demo class that adds to its demonstration of our code. We should be able to create a Penny with a different metallurgy now.
### Domain details
The Treasury Department undersecretary is very happy with your progress so far! They are now thinking that one area of concern for them is coin metallurgy. They want to explore various metallurgy options to increase coin longevity and durability while possibly reducing manufacturing costs.

United States coins specifications are indicated in table below.
Familiar name | value | frontMotto | backMotto | frontLabel | backLabel | frontImage | backImage | valueDescription | ridged edge | metallurgy
--------------| ----- | ---------- | --------- | ---------- | --------- | ---------- | --------- | ---------------- | ----------- | ----------
Penny | 0.01 | "IN GOD WE TRUST" | "E PLURIBUS UNUM" | "LIBERTY" | "UNITED STATES OF AMERICA" | "A_Lincoln" | "Lincoln_Memorial" | "ONE CENT" | no | "Copper"
Nickel | 0.05 | "IN GOD WE TRUST" | "E PLURIBUS UNUM" | "LIBERTY" | "UNITED STATES OF AMERICA" | "T_Jefferson" | "Jefferson_Memorial" | "FIVE CENTS" | no | "Cupro-Nickel"
Dime | 0.10 | "IN GOD WE TRUST" | "E PLURIBUS UNUM" | "LIBERTY" | "UNITED STATES OF AMERICA" | "F_Roosevelt" | "Torch_Branches" | "ONE DIME" | yes | "Cupro-Nickel"
Quarter | 0.25 | "IN GOD WE TRUST" | "E PLURIBUS UNUM" | "LIBERTY" | "UNITED STATES OF AMERICA" | "G_Washington" | "Eagle" | "QUARTER DOLLAR" | yes | "Cupro-Nickel"
HalfDollar | 0.50 | "IN GOD WE TRUST" | "E PLURIBUS UNUM" | "LIBERTY" | "UNITED STATES OF AMERICA" | "J_Kennedy" | "Presidential_Seal" | "HALF DOLLAR" | yes | "Cupro-Nickel"
Dollar | 1.00 | "IN GOD WE TRUST" | "E PLURIBUS UNUM" | "LIBERTY" | "UNITED STATES OF AMERICA" | "S_Anthony" | "Moon_Eagle" | "ONE DOLLAR" | yes | "Cupro-Nickel"

### Implementation details
Right now, our various concrete coin classes (e.g., Quarter) are passing a constant string that describes the metallurgy of its coin. We need this to be able to change. So we will employ the Strategy Design Pattern.

We will move the current metallurgy (the constant strings) into their own encapsulations. All of these various metallurgy encapsulations are related to each other by a common interface that we will call Metallurgy. This interface will require a String smelt() method that returns the string constant.

The Coin abstract class currently has a String metallurgy field. We will add a new composition with a Metallurgy delegate named smelter. The Coin class will have a new method ```void smelt()``` that it will call to set the metallurgy field. This smelt() method will relay the request to the smelter Metallurgy delegate.
