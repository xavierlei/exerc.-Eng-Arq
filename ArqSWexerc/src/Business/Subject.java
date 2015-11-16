/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observer;

/**
 *
 * @author xavier
 */
public class Subject {
    private HashMap<String,ArrayList<MyObserver>> obs;
    private boolean changedTodos = false;
    private boolean changedApostadores = false;
    private boolean changedInteressados = false;
    
    
    public Subject(){
        this.obs = new HashMap< String, ArrayList<MyObserver> >();
        ArrayList<MyObserver> todos = new ArrayList<MyObserver>();
        ArrayList<MyObserver> apostadores = new ArrayList<MyObserver>();
        ArrayList<MyObserver> interessados = new ArrayList<MyObserver>();
        this.obs.put("todos", todos);
        this.obs.put("apostadores", todos);
        this.obs.put("interessados", todos);
    }
    
    public void addObserver(String categoria, MyObserver obs){
        if(categoria.equals("todos")){
            if(!this.obs.get(categoria).contains(obs)){
                this.obs.get(categoria).add(obs);
            }  
        }
        else if(categoria.equals("apostadores")){
            if(!this.obs.get(categoria).contains(obs)){
                this.obs.get(categoria).add(obs);
            }
        }
        else if(categoria.equals("interessados")){
            if(!this.obs.get(categoria).contains(obs)){
                this.obs.get(categoria).add(obs);
            }
        }
    }
    public void deleteObserver(String categoria, MyObserver obs){
        if(categoria.equals("todos")){
            this.obs.get(categoria).remove(obs);
        }
        if(categoria.equals("apostadores")){
            this.obs.get(categoria).remove(obs);
        }
        if(categoria.equals("interessados")){
            this.obs.get(categoria).remove(obs);
        }
    }
    public void deleteObservers(String categoria){
        if(categoria.equals("todos")){
            this.obs.get(categoria).clear();
        }
        if(categoria.equals("apostadores")){
            this.obs.get(categoria).clear();
        }
        if(categoria.equals("interessados")){
            this.obs.get(categoria).clear();
        }
    }
    public void setChanged(String categoria){
        if(categoria.equals("todos")){
            this.changedTodos = true;
        }
        if(categoria.equals("apostadores")){
            this.changedApostadores = true;
        }
        if(categoria.equals("interessados")){
            this.changedInteressados = true;
        }
    }
    public boolean hasChanged(String categoria){
        if(categoria.equals("todos")){
            return this.changedTodos;
        }
        else if(categoria.equals("apostadores")){
            return this.changedApostadores;
        }
        else if(categoria.equals("interessados")){
            return this.changedInteressados;
        }
        else return false;
    }
    public void clearChanged(String categoria){
        if(categoria.equals("todos")){
            this.changedTodos = false;
        }
        else if(categoria.equals("apostadores")){
            this.changedApostadores = false;
        }
        else if(categoria.equals("interessados")){
            this.changedInteressados = false;
        }
    }
    public void notifyObservers(String categoria){
        if(categoria.equals("todos") && hasChanged(categoria)){
            for(MyObserver observer : this.obs.get(categoria)){
                observer.update(this,null);
            }
            clearChanged(categoria);
        }
        if(categoria.equals("apostadores") && hasChanged(categoria)){
            for(MyObserver observer : this.obs.get(categoria)){
                observer.update(this,null);
            }
            clearChanged(categoria);
        }
        if(categoria.equals("interessados") && hasChanged(categoria)){
            for(MyObserver observer : this.obs.get(categoria)){
                observer.update(this,null);
            }
            clearChanged(categoria);
        }
    }
    public void notifyObservers(String categoria, Object arg){
        if(categoria.equals("todos") && hasChanged(categoria) ){
            for(MyObserver observer : this.obs.get(categoria)){
                observer.update(this,arg);
            }
            clearChanged(categoria);
        }
        if(categoria.equals("apostadores") && hasChanged(categoria)){
            for(MyObserver observer : this.obs.get(categoria)){
                observer.update(this,arg);
            }
            clearChanged(categoria);
        }
        if(categoria.equals("interessados") && hasChanged(categoria)){
            for(MyObserver observer : this.obs.get(categoria) ){
                observer.update(this,arg);
            }
            clearChanged(categoria);
        }
    }
    public void notifyObserver(String categoria, MyObserver observer, Object arg){
        int index;
        if(categoria.equals("todos")){
            if(this.obs.get(categoria).contains(observer)){
                index = this.obs.get(categoria).indexOf(observer);
                this.obs.get(categoria).get(index).update(this, arg);
                clearChanged(categoria);
            }  
        }
        if(categoria.equals("apostadores")){
            if(this.obs.get(categoria).contains(observer) && hasChanged(categoria)){
                index = this.obs.get(categoria).indexOf(observer);
                this.obs.get(categoria).get(index).update(this, arg);
                clearChanged(categoria);
            }
        }
        if(categoria.equals("interessados")){
            if(this.obs.get(categoria).contains(observer)){
                index = this.obs.get(categoria).indexOf(observer);
                this.obs.get(categoria).get(index).update(this, arg);
                clearChanged(categoria);
            }
        }
    }
    
}
