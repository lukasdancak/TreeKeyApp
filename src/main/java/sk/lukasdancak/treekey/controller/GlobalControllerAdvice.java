package sk.lukasdancak.treekey.controller;

// This should be global binder via class with @ControllerAdvice annotation. It is not working now.



//import org.springframework.beans.propertyeditors.StringTrimmerEditor;
//import org.springframework.web.bind.WebDataBinder;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.InitBinder;
//
//@ControllerAdvice
//public class GlobalControllerAdvice {
//
//    @InitBinder
//    public void initBinder(WebDataBinder binder) {
//        StringTrimmerEditor stringtrimmer = new StringTrimmerEditor(false);
//        binder.registerCustomEditor(String.class, stringtrimmer);
//
//    }
//}