package sk.lukasdancak.treekey.dto;


public record TreeDTO(Long id,
                      String latinName,
                      String slovakName,
                      String description,
                      String familyName,
                      String habitusName,
                      String rhytidomeName,
                      String leafBladeShapeName,
                      String leafVeinsTypeName
                    ) {}
