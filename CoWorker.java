package lesson05.online;

/**
 * Created by Olga Shestakova
 * Date 29.04.2021
 */
    // Класс "Сотрудник";
    public class CoWorker {
        private String name;
        private String post;
        private int telephone;
        private int salary;
        private int age;

    // Конструктор класса;
    public CoWorker(String valueName, String valuePost, int valueTelephone, int valueSalary, int valueAge) {
        this.name = valueName;
        this.post = valuePost;
        this.telephone = valueTelephone;
        this.salary = valueSalary;
        this.age = valueAge;
    }
    // Методы, которые возвращают значение каждого поля;
    public String getName() {

        return name;
    }
    public String getPost(){

        return post;
    }
    public int getTelephone(){

        return telephone;
    }
    public int getSalary(){

        return salary;
    }
    public int getAge(){

        return age;
    }
    // Методы, которые перезаписыают значение поля;
    public void setSalary(int salary){

        this.salary = salary;
    }
}
