package hashtab;

import lombok.Data;

public class HashTabDemo {
    public static void main(String[] args) {
        HashTab tab = new HashTab(3);
        Employee e1 = new Employee(1, "tom");
        Employee e2 = new Employee(2, "jack");
        Employee e3 = new Employee(3, "daniel");
        tab.add(e1);
        tab.add(e2);
        tab.add(e3);
        tab.add(new Employee(7, "daniel2"));
        tab.add(new Employee(4, "daniel3"));
        tab.add(new Employee(5, "daniel4"));
        tab.add(new Employee(6, "daniel5"));
//        tab.list();
        System.out.println(tab.get(8));
    }

}

class HashTab {
    EmployeeLinkedList[] employeeLinkedListArr;
    int size;

    HashTab(int size) {
        this.size = size;
        employeeLinkedListArr = new EmployeeLinkedList[size];
    }

    void add(Employee employee) {
        int hash = fundHash(employee.id);
        if (employeeLinkedListArr[hash] == null) {
            employeeLinkedListArr[hash] = new EmployeeLinkedList();
        }
        employeeLinkedListArr[hash].add(employee);
    }

    void list() {
        for (int i = 0; i < size; i++) {
            if (employeeLinkedListArr[i] != null) {
                employeeLinkedListArr[i].list(i);
            }
        }
    }

    Employee get(int id) {
        int hash = fundHash(id);
        if (employeeLinkedListArr[hash] != null) {
            return employeeLinkedListArr[hash].get(id);
        }
        return null;
    }

    private int fundHash(int id) {
        return id % size;
    }


}


@Data
class EmployeeLinkedList {
    Employee head;

    void add(Employee employee) {
        if (head == null) {
            this.head = employee;
            return;
        }

        Employee curEmp = head;
        while (curEmp.next != null) {
            curEmp = curEmp.next;
        }
        curEmp.next = employee;
    }

    void list(int i) {
        if (head == null) {
            System.out.println("空链表");
            return;
        }
        Employee curEmp = head;
        System.out.println("第" + (i + 1) + "条链表：");
        System.out.println(curEmp);
        while (curEmp.next != null) {
            curEmp = curEmp.next;
            System.out.println(curEmp);
        }
    }


    public Employee get(int id) {
        if (head == null) {
            System.out.println("空链表");
            return null;
        }
        Employee curEmp = head;
        while (curEmp != null) {
            if (curEmp.id == id) {
                return curEmp;
            }
            curEmp = curEmp.next;
        }
        return null;
    }
}

@Data
class Employee {
    int id;
    String name;
    Employee next;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
