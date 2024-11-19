import java.util.List;
public class InheritanceP1 {

    public static class clsCountry
    {
        protected int id;

        private final String[] _countries = {
                "Syria",
                "Türkiye",
                "Jordon",
                "India",
                "Canada",
                "France",
                "Germany",
                "Italy",
                "United Kingdom",
                "United States",
        };

        protected void setId(int id)
        {
            this.id = (id < 0 || id >= _countries.length) ? 0 : id;
        }

        protected String get_country()
        {
            if (id < 0 || id >= _countries.length)
                return  _countries[0];

            return _countries[this.id];
        }
    }

    public static class clsPerson
    {
        private static int _AutoIncrementId = 0;
        private int _Id;
        private String _fName;
        private String _lName;
        private short _age;

        public String get_fName()
        {
            return _fName;
        }

        // using encapsulation we validated the data
        public void set_fName(String fName) {

            if (fName == null || fName.trim().isEmpty())
            {
                this._fName = "Unknown";
            }

            this._fName = fName;
        }

        public String get_lName()
        {
            return _lName;
        }

        // using encapsulation we validated the data
        public void set_lName(String lName)
        {
            this._lName = (lName == null || lName.trim().isEmpty()) ? "Unknown" : lName;
        }

        public short get_age()
        {
            return _age;
        }

        // using encapsulation we validated the data
        public void set_age(short age)
        {
            this._age = (age >=18 && age <= 60) ? this._age = age : 18;
        }

        public int get_Id()
        {
            return _Id;
        }

        // Composition
        private clsCountry Country = new clsCountry();

        public clsPerson(String fName, String lName, short age, int countryId)
        {
            this.set_fName(fName);
            this.set_lName(lName);
            this.set_age(age);
            this._Id = ++_AutoIncrementId;

            Country.setId(countryId);
        }

        @Override
        public String toString() {
            return "Id: " + this._Id +
                   "\nFull Name: " + this._fName + " " + this._lName +
                   "\nAge: " + this.get_age() +
                   "\nCountry: " + this.Country.get_country();
        }
    }

    public static class clsEmployee extends clsPerson
    {
        private String _JobTitle;
        public float _salary;

        public clsEmployee(String JobTitle, float salary, String fName, String lName, short age, int countryId)
        {
            super(fName, lName, age, countryId);

            set_JobTitle(JobTitle);
            set_salary(salary);
        }

        public String get_JobTitle()
        {
            return _JobTitle;
        }

        // using encapsulation we validated the data
        public void set_JobTitle(String JobTitle)
        {
            this._JobTitle = (JobTitle == null || JobTitle.trim().isEmpty()) ? "Unknown" : JobTitle.trim();
        }

        public float get_salary()
        {
            return _salary;
        }


        public void set_salary(float salary)
        {
            // 🤣
            // this._salary = salary < 17002 ? 17002 : salary ;
            this._salary = Math.max(salary, 17002);
        }

        @Override
        public String toString() {
            return super.toString() +
                   "\nSalary: " + this._salary +
                   "\nJob Title: " + this._JobTitle;
        }
    }

    public static class clsStudent extends clsPerson
    {
        private String _section;

        public clsStudent(String section, String fName, String lName, short age, int countryId)
        {
            super(fName, lName, age, countryId);
            set_section(section);
        }

        // using encapsulation we validated the data
        public void set_section(String _section)
        {
            this._section = (_section == null || _section.trim().isEmpty()) ? "Unknown" : _section.trim();
        }

        public String get_section() {
            return _section;
        }

        @Override
        public String toString() {
            return super.toString() +
                   "\nSection: " + this._section;
        }
    }

    private static final java.io.PrintStream out = System.out;

    public static void main(String[] args) {

        clsEmployee employee = new clsEmployee("Software Engineer",
                40000F,
                "Omer",
                "MEMES",
                (short) 24,
                1);

        out.println(employee);

        out.println("---------------------------------------");

        clsStudent student = new clsStudent("Computer Science",
                "Ali",
                "MEMES",
                (short) 20,
                0);

        out.println(student);
    }
}
