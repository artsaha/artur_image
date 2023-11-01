import os

# Get a list of all files in the current directory
files = os.listdir()

# Initialize an index variable
index = 1

# Loop through the files and rename them
for filename in files:
    # Check if it's a file (not a directory)
    if os.path.isfile(filename):
        # Get the file extension
        file_extension = os.path.splitext(filename)[-1]

        # Create the new filename with the prefix "MT_222" and the index
        new_filename = f"M109_M111_{index:03d}{file_extension}"

        # Rename the file
        os.rename(filename, new_filename)

        # Increment the index
        index += 1

print("Files have been renamed.")
