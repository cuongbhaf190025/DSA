/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import java.util.Scanner;

/**
 *
 * @author Cuong
 */
public class Main {

    public static int countWord(String input) {
        if (input == null) {
            return -1;
        }
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            count++;
        }
        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Myqueue mq = new Myqueue();
        MyStack ms = new MyStack();
        while (true) {
            System.out.println("Choose object: ");
            System.out.println("1: enter the character");
            System.out.println("2. Send message");

            System.out.println("3. Show received messages");
            System.out.println("4. Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1: {
                    String mess = " ";
                    System.out.println("Nhap ki tu: ");
                    do {
                        mess = sc.nextLine();
                        if (!"done".equals(mess)) {
                            if (countWord(mess) <= 250) {
                                mq.enqueue(new Node(mess));
                            } else {
                                System.out.println("over word");
                            }
                        }
                    } while (!"done".equals(mess));
                    break;
                }

                case 2: {
                    mq.display();
                    break;
                }
                case 3: {

                    while (!mq.isEmpty()) {
                        Node x = mq.dequeue();
                        ms.push(x);
                        System.out.println("Tin nhắn đang gửi");
                    }
                    System.out.println("Thư trong ngăn xếp ");

                    while (!ms.isEmpty()) {
                        System.out.println(ms.pop().getContent());
                    }
                    break;
                }
                case 4: {
                    System.exit(0);
                }
            }
        }
    }
}
