package org.example.mobile;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts = new ArrayList<>();

    public String getMyNumber() {
        return myNumber;
    }
    public ArrayList<Contact> getMyContacts() {
        return myContacts;
    }

    public MobilePhone(String myNumber, List<Contact> myContacts){
        this.myNumber = myNumber;
        if (myContacts != null) {
            this.myContacts = new ArrayList<>(myContacts);
        }
    }

    public boolean addNewContact(Contact contact){
        if(findContact(contact.getName()) >= 0){
            return false;
        }else{
            myContacts.add(contact);
            return true;
        }
    }

    public boolean updateContact(Contact oldContact, Contact newContact){
        if(myContacts.contains(oldContact)){
            int index = myContacts.indexOf(oldContact);
            myContacts.set(index, newContact);
            return true;
        }else{
            return false;
        }
    }

    public boolean removeContact(Contact contact){
        if(myContacts.contains(contact)){
            myContacts.remove(contact);
            return true;
        }else{
            return false;
        }
    }

    public int findContact(Contact contact){
        if(myContacts.contains(contact)){
            return myContacts.indexOf(contact);
        }else {
            return -1;
        }
    }
    public int findContact(String contact){
        int index = 0;
        for(Contact item : myContacts){
            if(item.getName().equals(contact)){
                return index;
            }else {
                index++;
            }
        }
        return -1;
    }

    public Contact queryContact(String contact){
        for (Contact item : myContacts){
            if(item.getName().equals(contact)){
                return item;
            }
        }
        return null;
    }

    public void printContact(){
        System.out.println("Contact List:");
        for(int i = 0; i < myContacts.size(); i++){
            System.out.println((i + 1) + ". " + myContacts.get(i).getName() + " -> " + myContacts.get(i).getPhoneNumber());
        }
    }
}