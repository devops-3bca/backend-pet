package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Pet;
import com.example.demo.service.PetService;

@RestController
@RequestMapping("/api/pets")
public class PetController {

    @Autowired
    private PetService petService;

    @PostMapping
    public ResponseEntity<?> addPet(@RequestBody Pet pet) {
        try {
            if (pet.getName() == null || pet.getName().trim().isEmpty()) {
                return ResponseEntity.badRequest().body("Pet name is required");
            }
            if (pet.getBreed() == null || pet.getBreed().trim().isEmpty()) {
                return ResponseEntity.badRequest().body("Breed is required");
            }
            if (pet.getAge() == null || pet.getAge().toString().trim().isEmpty()) {
                return ResponseEntity.badRequest().body("Age is required");
            }
            if (pet.getColor() == null || pet.getColor().trim().isEmpty()) {
                return ResponseEntity.badRequest().body("Color is required");
            }

            Pet savedPet = petService.addPet(pet);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedPet);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error saving pet: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Pet>> getAllPets() {
        try {
            return ResponseEntity.ok(petService.getAllPets());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/available")
    public ResponseEntity<List<Pet>> getAvailablePets() {
        try {
            return ResponseEntity.ok(petService.getAvailablePets());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/adopted")
    public ResponseEntity<List<Pet>> getAdoptedPets() {
        try {
            return ResponseEntity.ok(petService.getAdoptedPets());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> getPetById(@PathVariable Long id) {
        try {
            Optional<Pet> pet = petService.getPetById(id);
            return pet.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}/adopt")
    public ResponseEntity<?> adoptPet(@PathVariable Long id) {
        try {
            Pet adoptedPet = petService.markAsAdopted(id);
            if (adoptedPet != null) {
                return ResponseEntity.ok(adoptedPet);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pet not found");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error adopting pet: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePet(@PathVariable Long id) {
        try {
            Optional<Pet> pet = petService.getPetById(id);
            if (pet.isPresent()) {
                petService.deletePet(id);
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pet not found");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error deleting pet: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pet> updatePet(@PathVariable Long id, @RequestBody Pet petDetails) {
        try {
            Pet updatedPet = petService.updatePet(id, petDetails);
            if (updatedPet != null) {
                return ResponseEntity.ok(updatedPet);
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}