package com.shile;

/**
 * 通常,线程想要以不同的顺序获取相同的lock集合,就会导致deadlock
 * 这段程序,newTutor thread获取tutor lock,然后想获取student lock.studentThread获取Student lock,然后想要获取Tutor lock
 * 解决方案:
 * 1. 是否多个lock被多个线程以不同的顺序获取? 如果这样,是否我们可以强制所有的线程以相同的顺序获取lock
 * 2. 我们是否over-synchronizing代码
 * 3. 我们是否可以重写代码,打破循环模式
 * 4. 可以使用reentrantLock 对象
 */
public class Challenge8 {
    public static void main(String[] args) {
        final NewTutor newTutor = new NewTutor();
        final NewStudent newStudent = new NewStudent(newTutor);
        newTutor.setNewStudent(newStudent);

        Thread tutorThread = new Thread(new Runnable() {
            @Override
            public void run() {
                newTutor.studyTime();
            }
        });

        Thread studentThread = new Thread(new Runnable() {
            @Override
            public void run() {
                newStudent.handInAssignment();
            }
        });

        tutorThread.start();
        studentThread.start();
    }
}

class Tutor {
    private NewStudent newStudent;

    public synchronized void setNewStudent(NewStudent newStudent) {
        this.newStudent = newStudent;
    }

    public synchronized void studyTime() {
        System.out.println("NewTutor has arrived");
        try {
            // wait for newStudent to arrive and hand in assignment
            Thread.sleep(300);
        }
        catch (InterruptedException e) {

        }
        newStudent.startStudy();
        System.out.println("NewTutor is studying with newStudent");
    }

    public synchronized void getProgressReport() {
        // get progress report
        System.out.println("NewTutor gave progress report");
    }
}

class Student {

    private NewTutor newTutor;

    Student(NewTutor newTutor) {
        this.newTutor = newTutor;
    }

    public synchronized void startStudy() {
        // study
        System.out.println("NewStudent is studying");
    }

    public synchronized void handInAssignment() {
        newTutor.getProgressReport();
        System.out.println("NewStudent handed in assignment");
    }
}