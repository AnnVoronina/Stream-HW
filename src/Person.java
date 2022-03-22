public class Person {

    private String name;
    private Sex sex;
    private Education education;
    private String lastNane;
    private  Integer age;

    public Person(String name, String lastNane, Integer age, Sex sex, Education education) {
        this.name = name;
        this.lastNane = lastNane;
        this.age = age;
        this.sex = sex;
        this.education = education;
    }

    @Override
    public String toString() {
        return "\nPerson:" +
                "name: " + name +
                ",sex: " + sex +
                ",education: " + education +
                ",lastNane: " + lastNane +
                ",age:" + age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public void setLastNane(String lastNane) {
        this.lastNane = lastNane;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Sex getSex() {
        return sex;
    }

    public Education getEducation() {
        return education;
    }

    public String getLastNane() {
        return lastNane;
    }

    public Integer getAge() {
        return age;
    }
}



