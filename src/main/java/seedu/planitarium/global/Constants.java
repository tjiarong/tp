package seedu.planitarium.global;

public class Constants {
    // For Person component
    public static final int PARENTS = 1;
    public static final int MY_GEN = 2;
    public static final int CHILDREN = 3;
    public static final int NUM_GROUPS = 3;
    public static final int SINGULAR = 1;
    public static final boolean FOR_USER = false;
    public static final boolean FOR_STORAGE = true;

    // For Parser component
    public static final int INDEX_KEYWORD = 0;
    public static final int INDEX_LEFT_NOT_EXIST = 0;
    public static final int INDEX_LEFT_REMOVED = 1;
    public static final int INDEX_RIGHT_REMOVED = 0;
    public static final int LIMIT_TWO_TOKENS = 2;
    public static final int MIN_USER_INDEX = 1;
    public static final int MIN_EXPENDITURE_INDEX = 1;
    public static final int MIN_INCOME_INDEX = 1;
    public static final int MIN_CATEGORY_INDEX = 1;
    public static final int MIN_GROUP_INDEX = 1;
    // public static final int LIMIT_TWO_DECIMAL = 2; // placeholder
    public static final double MONEY_ZERO = 0.0;

    // For Help component
    public static final String ADD_PERSON = "Add a person: add /n NAME /g GROUP_INDEX";
    public static final String DELETE_PERSON = "Delete a person: delete /u USER_INDEX /g GROUP_INDEX";
    public static final String ADD_INCOME = "Add an income addin /u USER_INDEX /g GROUP_INDEX "
            + "/i INCOME /d DESCRIPTION /c CATEGORY_INDEX /p <T|F>";
    public static final String DELETE_INCOME = "Delete an income: deletein "
            + "/u USER_INDEX /g GROUP_INDEX /r INCOME_INDEX";
    public static final String EDIT_INCOME = "Edit an income: editin /u USER_INDEX /g GROUP_INDEX "
            + "/r INCOME_INDEX /i INCOME /d DESCRIPTION /c CATEGORY_INDEX /p <T|F>";
    public static final String ADD_EXPEND = "Add an expenditure: addout /u USER_INDEX /g GROUP_INDEX "
            + "/e EXPENDITURE /d DESCRIPTION /c CATEGORY_INDEX /p <T|F>";
    public static final String DELETE_EXPEND = "Delete an expenditure: deleteout /u USER_INDEX "
            + "/g GROUP_INDEX /r EXPENDITURE_INDEX";
    public static final String EDIT_EXPEND = "Edit an expenditure: editout /u USER_INDEX /g GROUP_INDEX "
            + "/r EXPENDITURE_INDEX /i EXPENDITURE /d DESCRIPTION /c CATEGORY_INDEX /p <T|F>";
    public static final String LIST = "List records by person: list";
    public static final String LIST_BY_GROUP = "List records by group: list /g GROUP_INDEX";
    public static final String LISTCAT = "List categories: listcat";
    public static final String HELP = "Show all commands: help";
    public static final String EXIT = "Exit program: bye";

    // For Command assertion
    public static final String NAME_NOT_NULL = "Name should not be null";
    public static final String PERSONLIST_NOT_NULL = "Personlist should not be null";
    public static final String DESCRIPTION_NOT_NULL = "Description should not be empty";
    public static final String INPUT_NOT_NULL = "Input should not be empty";
    public static final String KEYWORD_NOT_NULL = "Keywords should not be empty";
    public static final String FAMILY_NOT_NULL = "Family should not be null";
    public static final String USER_INDEX_NOT_VALID = "User index should be valid";

    // For Command logging
    public static final String LOG_ERROR_INFO = "Unknown error occurred in execution";
}
