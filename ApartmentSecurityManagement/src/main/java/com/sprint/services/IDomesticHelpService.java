package com.sprint.services;

import java.util.List;

import com.sprint.entities.DomesticHelp;
import com.sprint.entities.DomesticHelpType;

     public interface IDomesticHelpService {
    
     public List<DomesticHelp> getDomesticHelpList();
    
     public DomesticHelp getDomesticHelpById(Long id);
      
     public DomesticHelp addDomesticHelp(DomesticHelp domesticHelp);
         
     public DomesticHelp updateDomesticHelp(DomesticHelp domesticHelp);
        
     public DomesticHelp updateDomesticHelpById(Long id, DomesticHelpType oldHelpType , DomesticHelpType newHelpType);
      
}
