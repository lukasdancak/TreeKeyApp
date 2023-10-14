package sk.lukasdancak.treekey.dto;


public record TreeDTO(Long id,
                      String latinName,
                      String slovakName,
                      String description,
                      String familyName,
                      String primaryHabitusName,
                      String secondaryHabitusName,
                      String primaryRhytidomeName,
                      String secondaryRhytidomeName,
                      String leafBladeShapeName,
                      String leafVeinsTypeName
                    ) {}
