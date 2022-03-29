//@@author teanweijun

package seedu.planitarium.person;

import seedu.planitarium.ProjectLogger;
import seedu.planitarium.global.Constants;
import seedu.planitarium.money.Expenditure;
import seedu.planitarium.money.Income;
import seedu.planitarium.money.IncomeList;
import seedu.planitarium.money.ExpenditureList;

import java.util.ArrayList;
import java.util.logging.Level;

public class Person {
    private String name;
    private IncomeList incomeList;
    private ExpenditureList expenditureList;

    private static final String LOG_CLASS_NAME = Person.class.getSimpleName();
    private static final String LOG_FILE_PATH = LOG_CLASS_NAME + ".log";
    private static ProjectLogger logger = new ProjectLogger(LOG_CLASS_NAME, LOG_FILE_PATH);

    /**
     * Constructs a new Person object.
     *
     * @param name The name of the person to be created
     */
    public Person(String name) {
        String infoString = "Entering Person()";
        logger.log(Level.INFO, infoString);
        assert (name != null);
        this.name = name;
        infoString = "Non-null assertion passed in Person()";
        logger.log(Level.INFO, infoString);
        incomeList = new IncomeList();
        expenditureList = new ExpenditureList();
        logger.log(Level.INFO, Constants.PERSON_INIT_MESSAGE);
    }

    /**
     * Returns the name of the person.
     *
     * @return The name of the person
     */
    public String getName() {
        logger.log(Level.INFO, Constants.GET_NAME_CALL_MESSAGE);
        return name;
    }

    /**
     * Returns the list of incomes.
     *
     * @return The person's list of incomes
     */
    public ArrayList<Income> getIncomeList() {
        logger.log(Level.INFO, Constants.GET_INCOME_LIST_CALL_MESSAGE);
        return incomeList.getIncomeArrayList();
    }

    /**
     * Returns the list of expenditures.
     *
     * @return The person's list of expenditures
     */
    public ArrayList<Expenditure> getExpenditureList() {
        logger.log(Level.INFO, Constants.GET_EXPEND_LIST_CALL_MESSAGE);
        return expenditureList.getExpenditureArrayList();
    }

    /**
     * Adds an income to the list of incomes.
     *
     * @param description The source of the income
     * @param amount The value of the income
     * @param isPermanent Whether the income is recurring
     * @param isSilent Whether to print confirmation
     */
    public void addIncome(String description, double amount, boolean isPermanent, boolean isSilent) {
        logger.log(Level.INFO, Constants.ADD_INCOME_CALL_MESSAGE);
        incomeList.addIncome(description, amount, isPermanent);
        if (isSilent) {
            return;
        }
        if (isPermanent) {
            System.out.println("A recurring income of " + amount + " from " + description + " has been added to "
                    + name);
        } else {
            System.out.println("An income of " + amount + " from " + description + " has been added to " + name);
        }
    }

    /**
     * Removes an income from the list of incomes.
     *
     * @param incomeIndex The index of the income to be removed
     */
    public void deleteIncome(int incomeIndex) {
        String infoString = "Entering deleteIncome()";
        logger.log(Level.INFO, infoString);
        assert (incomeIndex >= Constants.SINGULAR);
        assert (incomeIndex <= getNumberOfIncomes());
        infoString = "Index assertions passed in deleteIncome()";
        logger.log(Level.INFO, infoString);
        String description = incomeList.getDescription(incomeIndex);
        double value = incomeList.getIncomeValue(incomeIndex);
        incomeList.remove(incomeIndex);
        System.out.println("An income of " + value + " for " + description + " has been removed from " + name);
    }

    /**
     * Adds an expenditure to the list of expenditures.
     *
     * @param description The reason for the expenditure
     * @param amount The value of the expenditure
     * @param category The category of the expenditure
     * @param isPermanent Whether the expenditure is recurring
     * @param isSilent Whether to print confirmation
     */
    public void addExpend(String description, double amount, int category, boolean isPermanent, boolean isSilent) {
        logger.log(Level.INFO, Constants.ADD_EXPEND_CALL_MESSAGE);
        expenditureList.addExpenditure(description, amount, category, isPermanent);
        if (isSilent) {
            return;
        }
        if (isPermanent) {
            System.out.println("A recurring expenditure of " + amount + " for " + description + " has been added to "
                    + name);
        } else {
            System.out.println("An expenditure of " + amount + " for " + description + " has been added to " + name);
        }
    }

    /**
     * Removes an expenditure from the list of expenditures.
     *
     * @param expendIndex The index of the expenditure to be removed.
     */
    public void deleteExpend(int expendIndex) {
        String infoString = "Entering deleteExpend()";
        logger.log(Level.INFO, infoString);
        assert (expendIndex >= Constants.SINGULAR);
        assert (expendIndex <= getNumberOfExpenditures());
        infoString = "Index assertions passed in deleteExpend()";
        String description = expenditureList.getDescription(expendIndex);
        double value = expenditureList.getExpenditureValue(expendIndex);
        expenditureList.remove(expendIndex);
        System.out.println("An expenditure of " + value + " for " + description
                + " has been removed from " + name);
    }

    /**
     * Lists the expenditures of the person.
     */
    public void listExpenditure() {
        logger.log(Level.INFO, Constants.LIST_EXPEND_CALL_MESSAGE);
        System.out.println("Here is the expenditure list for " + name + ":");
        expenditureList.printExpenditureList();
    }

    /**
     * Lists the income of the person.
     */
    public void listIncome() {
        logger.log(Level.INFO, Constants.LIST_INCOME_CALL_MESSAGE);
        System.out.println("Here is the income list for " + name + ":");
        incomeList.printIncomeList();
    }

    /**
     * Returns the total value of the person's expenditures.
     *
     * @return Total value of expenditures
     */
    public double getTotalExpenditure() {
        logger.log(Level.INFO, Constants.GET_TOTAL_EXPEND_CALL_MESSAGE);
        return expenditureList.getTotalExpenditure();
    }

    /**
     * Returns the total value of the person's incomes.
     *
     * @return Total value of incomes
     */
    public double getTotalIncome() {
        logger.log(Level.INFO, Constants.GET_TOTAL_INCOME_CALL_MESSAGE);
        return incomeList.getTotalIncome();
    }

    /**
     * Returns the amount of money leftover by the person. Can be negative.
     *
     * @return The total value contributed by the person
     */
    public double getDisposable() {
        logger.log(Level.INFO, Constants.GET_DISPOSABLE_CALL_MESSAGE);
        return getTotalIncome() - getTotalExpenditure();
    }

    /**
     * Returns the number of incomes the person has.
     *
     * @return The number of incomes
     */
    public int getNumberOfIncomes() {
        logger.log(Level.INFO, Constants.NUM_INCOMES_CALL_MESSAGE);
        return incomeList.getNumberOfIncomes();
    }

    /**
     * Returns the number of expenditures the person has.
     *
     * @return The number of expenditures
     */
    public int getNumberOfExpenditures() {
        logger.log(Level.INFO, Constants.NUM_EXPENDS_CALL_MESSAGE);
        return expenditureList.getNumberOfExpenditures();
    }

    /**
     * Returns the name in a format suitable for saving.
     *
     * @return The name with delimiter
     */
    public String saveName() {
        logger.log(Level.INFO, Constants.SAVE_NAME_CALL_MESSAGE);
        return "u " + name;
    }

    /**
     *  Edits an income in the list of incomes.
     *
     * @param incomeIndex The index of the income
     * @param description The source of the income
     * @param amount The value of the income
     * @param isPermanent Whether the income is recurring
     */
    public void editIncome(int incomeIndex, String description, double amount, boolean isPermanent) {
        logger.log(Level.INFO, Constants.EDIT_INCOME_CALL_MESSAGE);
        incomeList.editIncome(incomeIndex, description, amount, isPermanent);
    }

    /**
     *  Edits an expenditure in the list of expenditures of the specified person.
     *
     * @param expendIndex The index of the expenditure
     * @param description The reason for the expenditure
     * @param amount The value of the expenditure
     * @param category The category of the expenditure
     * @param isPermanent Whether the expenditure is recurring
     */
    public void editExpend(int expendIndex, String description, double amount, int category, boolean isPermanent) {
        logger.log(Level.INFO, Constants.EDIT_EXPEND_CALL_MESSAGE);
        expenditureList.editExpenditure(expendIndex, description, amount, category, isPermanent);
    }

    /**
     * Prints entries found in the category provided containing the stated description.
     *
     * @param description The string to look for
     * @param category The category of the entry
     */
    public void find(String description, int category) {
        logger.log(Level.INFO, Constants.FIND_CALL_MESSAGE);
        System.out.println("Entries found for " + name + ":");
        // incomeList.find(description);
        // expenditureList.find(description, category);
    }
}
