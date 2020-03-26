package array.com;

import java.util.ArrayList;

public class Mobile {

    private String myNumber;
    private ArrayList<Contacts> myContacts;

    public Mobile(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts =new ArrayList<Contacts>();
    }

    public boolean addContact(Contacts contact){
        if(findContact(contact) >=0){
            System.out.println("Contact is already exist");
            return false;
        }

        myContacts.add(contact);
        return true;
    }

    private int findContact(Contacts contact){
        return this.myContacts.indexOf(contact);
    }

    private int findContact(String contactName){

        for(int i =0; i < this.myContacts.size(); i++){
            Contacts contact = this.myContacts.get(i);
            if(contact.getName().equals(contactName)){
                return i;
            }
        }
        return -1;
    }

    public String queryContact(Contacts contact){
        if(findContact(contact)>=0){
            return contact.getName();
        }
        return null;
    }

    public Contacts queryContact(String name){
        int position= findContact(name);
        if(position >=0) return this.myContacts.get(position);

        return null;
    }


    public boolean updateContact(Contacts oldContact, Contacts newContact){
        int findPosition= findContact(oldContact);
        if(findPosition!=-1){
            this.myContacts.set(findPosition, newContact);
            System.out.println("Contact has been replaced");
            return true;
        }
            System.out.println("Contact is not exist");
            return false;
    }

    public boolean removeContact(Contacts contact ){
        int findPosition=findContact(contact);
        if(findPosition!=-1){
            this.myContacts.remove(findPosition);
            System.out.println("the "+ contact.getName()+"was  removed");
            return true;
        }
        System.out.println("the "+ contact.getName()+"was not found");
        return false;
    }

    public void printContacts(){
        System.out.println("Contact List");
        for(int i=0; i < this.myContacts.size();i++){
            System.out.println(i+1 + " "+
                    this.myContacts.get(i).getName()+ "-> "+
                    this.myContacts.get(i).getNumber());
        }
    }



}
