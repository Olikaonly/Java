package lesson05.online;

/**
 * Created by Olga Shestakova
 * Date 29.04.2021
 */
public class Fabric {
    public static void main(String[] args) {

        // Создать массив из 5 сотрудников ;

        CoWorker[] persArray = new CoWorker[5];
        persArray[0] = new CoWorker("Sasha", "CCO", 11111, 20000, 37);
        persArray[1] = new CoWorker("Slava", "CEO", 22222, 30000, 47);
        persArray[2] = new CoWorker("Nastya", "CFO", 33333, 50000, 50);
        persArray[3] = new CoWorker("Anya", "CIO", 44444, 35000, 35);
        persArray[4] = new CoWorker("Roma", "CMO", 555555, 25000, 30);

        //  С помощью цикла вывести информацию только о сотрудниках старше 40 лет;

        for (int i = 0; i < persArray.length; i++) {
            if (persArray[i].getAge() > 40) {
                System.out.println(persArray[i].getName() + " || " + persArray[i].getPost() + " || " + persArray[i].getAge());
            }
        }
        System.out.println("************************");

        // Метод, повышающий зарплату всем сотрудникам старше 35 лет на 10000;

        int salary;
        for (int i = 0; i < persArray.length; i++) {
            if (persArray[i].getAge() > 35) {
                salary = persArray[i].getSalary();
                persArray[i].setSalary(salary + 10000);
            }
            System.out.println(persArray[i].getName() + " || " + persArray[i].getSalary() + " || " + persArray[i].getAge());
        }
        System.out.println("************************");

        //Вывести при помощи методов из пункта 3 ФИО и должность;

                System.out.println(persArray[1].getName() + " || " + persArray[1].getPost() );

        }
    }

