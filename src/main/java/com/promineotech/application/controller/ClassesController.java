/**
 * 
 */
package com.promineotech.application.controller;

import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.application.entity.Classes;
import com.promineotech.application.entity.Student;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

/**
 * @author Joeit
 *
 */
@Validated
public interface ClassesController {
  @Operation(
      summary = "Creates a Class",
      description = "Returns Class Object when successfully created a new class!",
      responses = {
          @ApiResponse(
              responseCode = "201", 
              description = "Class has been created", 
              content = @Content(
                  mediaType = "application/json", 
              schema = @Schema(implementation = Student.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid.", 
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "Unplanned error occured, Student could not be created!", 
              content = @Content(
                  mediaType = "application/json"))
      },
      parameters = {
          @Parameter(
              name = "subject", 
              allowEmptyValue = false, 
              required = true, 
              description = "The Classes Subject (i.e., 'MATH  ')"), 
          @Parameter(
              name = "gradeYear", 
              allowEmptyValue = false, 
              required = true, 
              description = "The students Last Name (i.e., '210')"),
     }
  )
  @PostMapping
  @ResponseStatus(code = HttpStatus.OK)
  Optional<Classes> createClass(
      @RequestParam(required = true)
      String subject,
      @RequestParam(required = true)
      Integer gradeYear
      );
 
  
  @Operation(
      summary = "Deletes a class from the Classes table.",
      description = "Delete a class given a required class Primary key.",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A class is deleted.", 
              content = @Content(
                  mediaType = "application/json", 
              schema = @Schema(implementation = Student.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid.", 
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No classes were found with that Primary Key.", 
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occurred.", 
              content = @Content(
                  mediaType = "application/json"))
      },
      parameters = {
          @Parameter(
              name = "classPk", 
              allowEmptyValue = false, 
              required = true, 
              description = "The class Primary Key (i.e., 'MATH210')"), 
      }
  )
   // Delete method (Delete)
   @DeleteMapping
   @ResponseStatus(code = HttpStatus.OK)
   Optional<Classes> deleteClass(
       @RequestParam(required = false) 
       String classPk);
  
}
