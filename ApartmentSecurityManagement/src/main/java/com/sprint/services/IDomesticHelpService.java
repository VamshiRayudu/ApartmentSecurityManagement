package com.sprint.services;

import java.util.List;

import com.sprint.entities.DomesticHelp;

     public interface IDomesticHelpService {
    
     public List<DomesticHelp> getDomesticHelpList();
    
     public DomesticHelp getDomesticHelpById(Long id);
      
     public DomesticHelp addDomesticHelp(DomesticHelp domesticHelp);
         
     public List<DomesticHelp> updateDomesticHelpList();
        
     public DomesticHelp updateDomesticHelpById(Long id);
      
}